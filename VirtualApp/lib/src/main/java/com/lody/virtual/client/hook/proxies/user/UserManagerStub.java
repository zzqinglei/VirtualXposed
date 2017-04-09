package com.lody.virtual.client.hook.proxies.user;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import com.lody.virtual.client.hook.base.BinderInvocationProxy;
import com.lody.virtual.client.hook.base.ReplaceCallingPkgMethodProxy;
import com.lody.virtual.client.hook.base.ResultStaticMethodProxy;

import java.util.Collections;

import mirror.android.os.IUserManager;

/**
 * @author Lody
 *
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class UserManagerStub extends BinderInvocationProxy {

	public UserManagerStub() {
		super(IUserManager.Stub.asInterface, Context.USER_SERVICE);
	}

	@Override
	protected void onBindHooks() {
		super.onBindHooks();
		addMethodProxy(new ReplaceCallingPkgMethodProxy("setApplicationRestrictions"));
		addMethodProxy(new ReplaceCallingPkgMethodProxy("getApplicationRestrictions"));
		addMethodProxy(new ReplaceCallingPkgMethodProxy("getApplicationRestrictionsForUser"));
		addMethodProxy(new ResultStaticMethodProxy("getProfileParent", null));
		addMethodProxy(new ResultStaticMethodProxy("getUserIcon", null));
		addMethodProxy(new ResultStaticMethodProxy("getUserInfo", null));
		addMethodProxy(new ResultStaticMethodProxy("getDefaultGuestRestrictions", null));
		addMethodProxy(new ResultStaticMethodProxy("setDefaultGuestRestrictions", null));
		addMethodProxy(new ResultStaticMethodProxy("removeRestrictions", null));
		addMethodProxy(new ResultStaticMethodProxy("getUsers", Collections.EMPTY_LIST));
		addMethodProxy(new ResultStaticMethodProxy("createUser", null));
		addMethodProxy(new ResultStaticMethodProxy("createProfileForUser", null));
		addMethodProxy(new ResultStaticMethodProxy("getProfiles", Collections.EMPTY_LIST));
	}
}
