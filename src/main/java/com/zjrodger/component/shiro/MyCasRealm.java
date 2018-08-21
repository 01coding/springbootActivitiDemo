//package com.zjrodger.component.shiro;
//
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.cas.CasAuthenticationException;
//import org.apache.shiro.cas.CasRealm;
//import org.apache.shiro.cas.CasToken;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.StringUtils;
//import org.jasig.cas.client.authentication.AttributePrincipal;
//import org.jasig.cas.client.validation.Assertion;
//import org.jasig.cas.client.validation.TicketValidationException;
//import org.jasig.cas.client.validation.TicketValidator;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//
//import java.util.Map;
//
///**
// * @author zhangjian
// * @create 2018-08-16
// */
//public class MyCasRealm extends CasRealm {
//
//    private static final Logger log = LoggerFactory.getLogger(MyCasRealm.class);
//
//    @Autowired
//    protected OAuth2RestTemplate restTemplate;
//
//    @Value("${rest.uc.queryPermissions}")
//    private String restUcQueryPermissionsUrl;
//
//    @Value("${rest.uc.queryStaffByUsername}")
//    private String restUcQueryStaffByUsernameUrl;
//
//    @Value("${local.login.url}")
//    private String localLoginUrl;
//
//    public MyCasRealm() {
//        super();
//        setAuthenticationTokenClass(CasToken.class);
//    }
//
//    /**
//     * 重写cas服务端返回客户端认证处理
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {// NOSONAR
//        CasToken casToken = (CasToken) token;
//        if (token == null) {
//            return null;
//        }
//        String ticket = (String) casToken.getCredentials();
//        if (!StringUtils.hasText(ticket)) {
//            return null;
//        }
//        TicketValidator ticketValidator = ensureTicketValidator();
//        try {
//            Assertion casAssertion = ticketValidator.validate(ticket, getCasService());
//            AttributePrincipal casPrincipal = casAssertion.getPrincipal();
//            String userId = casPrincipal.getName();
//            Map<String, Object> attributes = casPrincipal.getAttributes();
//            casToken.setUserId(userId);
//            String rememberMeAttributeName = getRememberMeAttributeName();
//            String rememberMeStringValue = (String) attributes.get(rememberMeAttributeName);
//            boolean isRemembered = rememberMeStringValue != null && Boolean.parseBoolean(rememberMeStringValue);
//            if (isRemembered) {
//                casToken.setRememberMe(true);
//            }
//            StringBuilder sb = new StringBuilder();
//            sb.append(restUcQueryStaffByUsernameUrl);
//            sb.append("?username=");
//            sb.append(userId.trim());
//            String url = sb.toString();
//            log.info("调用UC根据用户名获取用户信息接口:{}" , url);
//            RemoteStaffVo ucStaffVo = restTemplate.getForObject(url, RemoteStaffVo.class);
//            if (ucStaffVo == null) {
//                return null;
//            }
//            return new SimpleAuthenticationInfo(ucStaffVo, token.getCredentials(), userId);
//
//            return null;
//        } catch (TicketValidationException e) {
//            throw new CasAuthenticationException("Unable to validate ticket [" + ticket + "]", e);
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//
//    /**
//     * 重写cas客户諯权限控制
//     */
//    @SuppressWarnings("unchecked")
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        try {
//            RemoteStaffVo staff = (RemoteStaffVo) principals.getPrimaryPrincipal();
//            if (staff == null) {
//                return null;
//            }
//            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//            Set<RemoteRbacRoleVo> roles = staff.getRoles();
//            for (RemoteRbacRoleVo role : roles) {
//                simpleAuthorizationInfo.addRole(role.getName());
//            }
//            List<String> permiss = new ArrayList<>();
//
//            List<Map<String, Object>> list = restTemplate.getForObject(restUcQueryPermissionsUrl, List.class,
//                    new Object[] { staff.getId() });
//            for (Map<String, Object> map : list) {
//                permiss.add(map.get("code").toString());
//            }
//            simpleAuthorizationInfo.addStringPermissions(permiss);
//            return simpleAuthorizationInfo;
//        } catch (Exception e) {
//            log.error("Get staff permission error!reason", e);
//        }
//        return null;
//    }
//
//
//}
